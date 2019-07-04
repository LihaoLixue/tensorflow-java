package com.tensorflow.model.java.two;

import org.apache.commons.io.IOUtils;
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created on 2019-07-03
 *
 * @author :hao.li
 */
public class reload_3 {
    public static void main(String[] args) throws IOException {
        try (Graph graph = new Graph()) {
            //导入图
            byte[] graphBytes = IOUtils.toByteArray(new FileInputStream("/Users/lixuewei/workspace/private/tensorflow-java/model_2/src/main/model/model_3.pb"));
            graph.importGraphDef(graphBytes);

            //根据图建立Session
            try(Session session = new Session(graph)){
                //相当于TensorFlow Python中的sess.run(z, feed_dict = {'x': 10.0})
                Tensor tensor = session.runner()
                        .feed("x", Tensor.create(10))
                        .feed("y", Tensor.create(3))
                        .fetch("op_to_store").run().get(0);
                System.out.println(tensor.intValue());
            }
        }

    }
}
