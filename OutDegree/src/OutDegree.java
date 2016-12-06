import org.apache.giraph.graph.BasicComputation;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.giraph.graph.Vertex;

import java.io.IOException;

/**
 * Simple job to compute the out-degree for each vertex.
 */
public class OutDegree extends BasicComputation<
	LongWritable, LongWritable, NullWritable, DoubleWritable> {

	@Override
	public void compute(
			Vertex<LongWritable, LongWritable, NullWritable> vertex,
			Iterable<DoubleWritable> messages) throws IOException {
		LongWritable vertexValue = vertex.getValue();
		vertexValue.set(vertex.getNumEdges());
		vertex.setValue(vertexValue);
		vertex.voteToHalt();
	}
}
