

#include"com_example_ndk_ArraySum.h"

#include<stdio.h>



JNIEXPORT jint JNICALL Java_com_example_ndk_ArraySum_getSum
  (JNIEnv *env, jclass jclass, jintArray arr){

    int buf[10];

    int result=0;
    int i;
     (*env)->GetIntArrayRegion(env,arr,0,10,buf);



    for(i=0;i<10;i++){

       result+=buf[i];
    }
    return result;
  }




JNIEXPORT jint JNICALL Java_com_example_ndk_ArraySum_getSum2
  (JNIEnv *env, jclass jclass, jintArray arr){

  int result=0;

  int *p=(*env)->GetIntArrayElements(env,arr,NULL);

  int len=(*env)->GetArrayLength(env,arr);



   int i=0;
   for(;i<len;i++){
        result+=*(p+i);
   }

    return result;

  }



JNIEXPORT jobjectArray JNICALL Java_com_example_ndk_ArraySum_get2DArraySum
  (JNIEnv * env, jclass jcc , jint size){

  jobjectArray result;
  jclass jintClass=(*env)->FindClass(env,"I");//这个方法的签名可能存在问题

//  jclass jStringClass=(*env)->FindClass(env,"Ljava/lang/String");


  result=(*env)->NewObjectArray(env,size,jintClass,NULL);//创建一个jobjectArray对象

  int i=0;
  for(;i<size;i++){

        int temp[256];
        jintArray jArr=(*env)->NewIntArray(env,size);//创建一个java的整型数组

        int j=0;
        for(;j<size;j++){
           temp[j]=20+j;
        }

        (*env)->SetIntArrayRegion(env,jArr,0,size,temp);//将temp上面的数据copy一共size大小到jArr

        (*env)->SetObjectArrayElement(env,result,i,jArr);

          (*env)->DeleteLocalRef(env,jArr);
  }
  return result;

  }








