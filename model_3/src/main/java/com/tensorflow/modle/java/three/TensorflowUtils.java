package com.tensorflow.modle.java.three;

/**
 * Created on 2019-07-03
 *
 * @author :hao.li
 */

import org.tensorflow.SavedModelBundle;

public class TensorflowUtils {
    public static SavedModelBundle loadmodel(String modelpath) {
        SavedModelBundle bundle = SavedModelBundle.load(modelpath, "serve");
        return bundle;
    }

}
