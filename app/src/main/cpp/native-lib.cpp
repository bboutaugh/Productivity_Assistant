#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_productivityassistant_group14_productivity_1assistant_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
