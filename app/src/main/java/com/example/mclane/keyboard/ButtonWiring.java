package com.example.mclane.keyboard;

/**
 * Created by per6 on 9/11/17.
 */

public class ButtonWiring {
    public static void main(String[] args) {
        String str = "edcdeeedddeggedcdeeeeddedc";
        for(int i = 0; i < str.length(); i++){
            String l = str.substring(i,i+1);
            System.out.print(l+"Button, ");
        }
    }
}
