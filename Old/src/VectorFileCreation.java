import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.mahout.math.DenseVector;
import org.apache.mahout.math.NamedVector;
import org.apache.mahout.math.VectorWritable;

class VectorFileCreation {

	public static final int Num_Features = 2;

	public static void main(String[] args) throws Exception {
		String INPUT_FILE = "input.csv";
		String OUTPUT_FILE = "seqfile";
		List<NamedVector> vectors = new ArrayList<NamedVector>();
		NamedVector nvector;
		
		BufferedReader br = null;
		br = new BufferedReader(new FileReader(INPUT_FILE));
		
		String sCurrentLine;
		while ((sCurrentLine = br.readLine()) != null) {
			String[] elems =  sCurrentLine.split(",");
			String item_name = elems[0];
			double[] features = new double[Num_Features];
			for (int indx = 1; indx <= Num_Features; ++indx) {
				features[indx - 1] = Double.parseDouble(elems[indx]);
			}
			nvector = new NamedVector(new DenseVector(features), item_name);
			vectors.add(nvector);
		}
		
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		Path path = new Path(OUTPUT_FILE);
		SequenceFile.Writer writer = new SequenceFile.Writer(fs, conf, path,Text.class, VectorWritable.class);
		VectorWritable vec = new VectorWritable();
		
		for (NamedVector vector : vectors) {
			vec.set(vector);
			writer.append(new Text(vector.getName()), vec);
		}
		writer.close();
		
		SequenceFile.Reader reader = new SequenceFile.Reader(fs, new Path(OUTPUT_FILE), conf);
		Text key = new Text();
		VectorWritable value = new VectorWritable();
		
		while (reader.next(key, value)) {
			System.out.println(key.toString() + ","+ value.get().asFormatString());
		}
		reader.close();
	}
}