import org.apache.giraph.graph.BasicComputation;
import org.apache.giraph.edge.Edge;
import org.apache.giraph.graph.Vertex;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.LongWritable;

import java.io.IOException;

/**
 * Simple job to compute the in-degree for each vertex.
 */
public class InDegree extends BasicComputation<
	LongWritable, LongWritable, NullWritable, DoubleWritable> {

	@Override
	public void compute(
			Vertex<LongWritable, LongWritable, NullWritable> vertex,
			Iterable<DoubleWritable> messages) throws IOException {

			// TODO write your code here...
	}
}
