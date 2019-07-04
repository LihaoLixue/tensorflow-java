package com.tensorflow.model.java.one;

import org.apache.commons.io.IOUtils;
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import java.io.FileInputStream;
import java.io.IOException;

public class DemoImportGraph {

    public static void main(String[] args) throws IOException {
        try (Graph graph = new Graph()) {
            //导入图
            byte[] graphBytes = IOUtils.toByteArray(new FileInputStream("/Users/lixuewei/workspace/private/tensorflow-java/model_1/src/main/model/model.pb"));
            graph.importGraphDef(graphBytes);

            //根据图建立Session
            try(Session session = new Session(graph)){
                //相当于TensorFlow Python中的sess.run(z, feed_dict = {'x': 10.0})
                Tensor tensor = session.runner()
                        .feed("x", Tensor.create(10.0f))
                        .fetch("z").run().get(0);
                System.out.println(tensor.floatValue());
            }
        }

    }
}
