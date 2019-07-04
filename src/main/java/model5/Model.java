package model5;

/**
 * Created on 2019-07-03
 *
 * @author :hao.li
 */

import org.tensorflow.SavedModelBundle;
import org.tensorflow.Tensor;

import java.util.Arrays;

public class Model {

    SavedModelBundle bundle = null;

    public void init() {
//        String classpath = this.getClass().getResource("/").getPath() + "1";
        String classpath = "/Users/lixuewei/workspace/private/tensorflow-java/src/main/model/1/";
        bundle = TensorflowUtils.loadmodel(classpath);
    }

    public double getResult(float[][] arr) {
        Tensor tensor = Tensor.create(arr);
        Tensor result = bundle.session().runner().feed("x", tensor).fetch("y").run().get(0);
        float[][] resultValues = (float[][]) result.copyTo(new float[1][1]);
        result.close();
        return resultValues[0][0];

    }

    public static void main(String[] args) {
        Model model = new Model();
        model.init();
        float[][] arr = new float[1][3];
        arr[0][0] = 1.0f;
        arr[0][1] = 0.5f;
        arr[0][2] = 2.0f;
        System.out.println(model.getResult(arr));
        System.out.println(Arrays.toString("他".getBytes()));

    }


}


