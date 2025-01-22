package com.collectionlist.utility;

import com.collectionlist.actiondriver.Action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader
{

        public static Properties config;
        public static Properties OR;
        public static Properties TextProp;
        public static String rootDir = Action.getRootDirectory();

        /**
         * Load property file.
         *
         * @param
         */
        public static void loadProperties(){

            config = new Properties();
            OR = new Properties();
            TextProp = new Properties();

            try {

                InputStream input1 = new FileInputStream(rootDir+"/CollectionList/Configuration/Config.properties");

                config.load(input1);

                InputStream input2 = new FileInputStream(rootDir+"/CollectionList/Configuration/ObjectRepo.properties");

                OR.load(input2);

                InputStream input3 = new FileInputStream(rootDir+"/CollectionList/Configuration/Text.properties");

                TextProp.load(input3);


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }




}
