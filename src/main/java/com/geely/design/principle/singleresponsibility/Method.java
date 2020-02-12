package com.geely.design.principle.singleresponsibility;

/**
 * Created by geely
 */
public class Method {


    /**********************下面的方法职责重叠********************/
    // 既更新了名字又更新了地址
    private void updateUserInfo(String userName,String address){
        userName = "geely";
        address = "beijing";
    }

    private void updateUserInfo(String userName,String... properties){
        userName = "geely";
//        address = "beijing";
    }

    /***********************************************/



    /**********************重构如下********************/
    private void updateUsername(String userName){
        userName = "geely";
    }
    private void updateUserAddress(String address){
        address = "beijing";
    }

    /***********************************************/


    // 像这种方法的，建议重构
    private void updateUserInfo(String userName,String address,boolean bool){

        // 像这样的，明显是两个职责，建议拆开
        if(bool){
            //todo something1
        }else{
            //todo something2
        }


        userName = "geely";
        address = "beijing";
    }


}
