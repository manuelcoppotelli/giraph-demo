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

	@Override
	public void compute(
			Vertex<LongWritable, DoubleWritable, FloatWritable> vertex,
			Iterable<DoubleWritable> messages) throws IOException {

	}
}
