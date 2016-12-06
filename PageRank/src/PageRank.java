import org.apache.giraph.graph.BasicComputation;
import org.apache.giraph.graph.Vertex;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;

import com.google.common.collect.Lists;

import java.io.IOException;
import java.util.List;

/**
 * Demonstrates the basic Pregel PageRank implementation.
 */
public class PageRank extends BasicComputation<LongWritable,
		DoubleWritable, FloatWritable, DoubleWritable> {
	/** Number of supersteps for this test */
	public static final int MAX_SUPERSTEPS = 30;

	@Override
	public void compute(
			Vertex<LongWritable, DoubleWritable, FloatWritable> vertex,
			Iterable<DoubleWritable> messages) throws IOException {
		if (getSuperstep() >= 1) {
			double sum = 0;
			for (DoubleWritable message : messages) {
				sum += message.get();
			}
			DoubleWritable vertexValue =
					new DoubleWritable((0.15f / getTotalNumVertices()) + 0.85f * sum);
			vertex.setValue(vertexValue);
		}

		if (getSuperstep() < MAX_SUPERSTEPS) {
			long edges = vertex.getNumEdges();
			sendMessageToAllEdges(vertex,
					new DoubleWritable(vertex.getValue().get() / edges));
		} else {
			vertex.voteToHalt();
		}
	}
}
