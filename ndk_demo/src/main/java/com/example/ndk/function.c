


//笔记

1.日志的输出

  #define LOGI(...) __android_log_print(ANDROID_LOG_INFO,TAG,__VA_ARGS__)

//下面是实现的代码


#include<android/log.h>

#define TAG="ndknativelog"


/**
 *@param ANDROID_LOG_INFO android的在日志级别
 *@param TAG 我们定义的tag，用于过滤信息
 *
*/
#define  LOGI(...) __android_log_print(ANDROID_LOG_INFO,TAG,__VA_ARGS__);

JNIEXPORT void JNICALL Java_com_example_ndk_NativeLogUtil_log
  (JNIEnv * env, jclass obj){

        LOGI("I LOVE THIS WORLD");
  }


下面是添加到build.gradle的代码
添加到 android节点下面:

sourceSets.main{
    jniLibs.srcDir="src/main/libs"
    jni.srcDirs=[]
}

task ndkBuild(type: Exec){
    //ndk的目录
    commandLine "/home/fang/Android/Sdk/ndk-bundle",'-C',file('src')
}

task.withType(JavaCompile){
    compileTask -> compileTask.dependsOn ndkBuild
}




2.直接编写native文件

    一般格式







3.jni的api

jstring NewStringUTF(JNIEnv *env,const char *bytes);
//利用UTF-8字符数组构造新的java.lang.String的对象



4.数组访问

void (* GetIntArrayRegion)(JNIEnv *,jintArray,jsize a,jsize b,jint *buf);
//将jintArray数组中从a～b中的数据复制到buf中

jint *(*GetIntArrayElements)(JNIEnv *,jintArray,jboolean *);
//将java数组转换成c的数组，如果isCopy不是NULL,*isCopy在复制完成后即将被设为JNI_TRUE;如果
//未复制，则设为JNI_FALSE ，返回指向c数组的指针

jarray NewObjectArray(JNIEnv *env ,jsize length,jclass elementClass,jobject initialElement);
//构造新的数组，他将保存类elementClass中的对象 所有 元素初始值设为initialElement

jsize (*GetArrayLength)(JNIEnv *,jarray);
//获得数组的长度

jclass (*FindClass)(JNIEnv *,const char *);
//查找类 参数二是标识符  使用javap可以查看函数的标识符

jobjectArray (*NewObjectArray)(JNIEnv *,jsize,jclass,jobject);
//创建一个对象数组


下面编写一些代码

jsize size=10;

jobjectArray result;
jclass jintClass=(*env)->FindClass(env,"LI");
result=(*env)->NewObjectArray(env,jsize,jintClass,NULL);

int i=0;
for(i=0i<size;i++){
    int temp[256];

    jintArray jArr=(* env)->NewIntArray(env,size);

   int j;
   for(j=0;j<size;j++){

        temp[j]=20+j;

   }

   (* env)->SetIntArrayRegion(env,jArr,0,size,temp);

   (*env)->SetObjectArrayElement(env,result,i,jArr);

}
//垃圾回收
(*env).DeleteLocalRef(env,jArr);
return result;



//对象字段的操作
jclass GetObjectClass(JNIEnv * env,jobject obj);
//通过对象获取这个类，该函数比较简单，唯一注意的地方是对象不能为NULL，否则获取的class肯定返回也为Null

jfieldID GetFieldID(JNIEnv *env,jclass clazz,const char *name,const char *sig);
//返回java类(非静态)域的属性id

jobject GetObjectField(jobject obj,jfieldID fieldID);
//根据field获取相应的field






















