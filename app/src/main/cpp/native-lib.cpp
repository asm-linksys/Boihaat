#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_groupone_green_1red_boihaat_LoginActivityMain_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
