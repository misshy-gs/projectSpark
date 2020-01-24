package org.shyam

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object Count {
  def main(args : Array[String]){
    /*val conf = new SparkConf().setAppName("Count")
    val sc = new SparkContext(conf)

    val rdd = sc.parallelize(Seq(1,2,3,4,5))
    println(rdd.count)*/

    val spark = SparkSession
      .builder()
      .appName("Spark sql example")
      .getOrCreate()

    /*val myRange = spark.range(1000).toDF("number")
    myRange.show*/

    val sampleData = spark
      .read
      .option("inferSchema","true")
      .option("header","true")
      .csv("D:\\Sample Data\\FL_insurance_sample.csv")

    sampleData.show
  }
}
