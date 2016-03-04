package org.myorg;

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;

public class HW2 {

	public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text> {
	  private Text region = new Text();
	  private Text content = new Text();
	  public void map(LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
		String line = value.toString();
		String [] words = line.split(",");
		String regionID = words[5];
		String messages = words[2] + "," + words[3] + "," + words[4];
		region.set(regionID);
		content.set(messages);
		output.collect(region, content);
	  }
	}

	public static class Reduce extends MapReduceBase implements Reducer<Text, Text, Text, Text> {
	  public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
		int impression = 0;
		int click = 0;
		int conversion = 0;
		while (values.hasNext()) {
			String [] number = values.next().toString().split(",");
			impression += Integer.parseInt(number[0]); 
			click += Integer.parseInt(number[1]); 
			conversion += Integer.parseInt(number[2]); 
		}
		String result = "," + impression + "," + click + "," + conversion;
		Text record = new Text(result);
		output.collect(key, record);
	  }
	}

	public static void main(String[] args) throws Exception {
	  JobConf conf = new JobConf(HW2.class);
	  conf.setJobName("wordcount");

	  conf.setOutputKeyClass(Text.class);
	  conf.setOutputValueClass(Text.class);

	  conf.setMapperClass(Map.class);
//	  conf.setCombinerClass(Reduce.class);
	  conf.setReducerClass(Reduce.class);

	  conf.setInputFormat(TextInputFormat.class);
	  conf.setOutputFormat(TextOutputFormat.class);

	  FileInputFormat.setInputPaths(conf, new Path(args[0]));
	  FileOutputFormat.setOutputPath(conf, new Path(args[1]));

	  JobClient.runJob(conf);
	}
}