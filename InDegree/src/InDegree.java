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
		if (getSuperstep() == 0) {
			Iterable<Edge<LongWritable, NullWritable>> edges = vertex.getEdges();
			for (Edge<LongWritable, NullWritable> edge : edges) {
				sendMessage(edge.getTargetVertexId(), new DoubleWritable(1.0));
			}
		} else {
			long sum = 0;
			for (DoubleWritable message : messages) {
				sum++;
			}
			LongWritable vertexValue = vertex.getValue();
			vertexValue.set(sum);
			vertex.setValue(vertexValue);
			vertex.voteToHalt();
		}
	}
}
