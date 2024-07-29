#include "jni.h"
#include "CGUIManager.h"

jobject CGUIManager::jobject1;

extern "C"
JNIEXPORT void JNICALL
Java_com_rockstargames_gtacr_GUIManager_initGUIManager(JNIEnv *env, jobject thiz) {
    CGUIManager::jobject1 = env->NewGlobalRef(thiz);
}

extern "C" JavaVM* javaVM;

JNIEnv * CGUIManager::GetEnv()
{
    JNIEnv* env = nullptr;
    int getEnvStat = javaVM->GetEnv((void**)& env, JNI_VERSION_1_6);

    if (getEnvStat == JNI_EDETACHED)
    {
        if (javaVM->AttachCurrentThread(&env, NULL) != 0) return nullptr;
    }

    if (getEnvStat == JNI_EVERSION) return nullptr;
    if (getEnvStat == JNI_ERR) return nullptr;

    return env;
}

void CGUIManager::ShowGUI(int i, jobject jobject2) {
    JNIEnv *env = CGUIManager::GetEnv();
    if (!env) return;

    env->CallVoidMethod(CGUIManager::jobject1, env->GetMethodID(
            env->GetObjectClass(CGUIManager::jobject1), "showGUI", "(ILorg/json/JSONObject;)V"
            ), i, jobject2);
}

void CGUIManager::HideGUI(int i, jobject pJobject) {
    JNIEnv *env = CGUIManager::GetEnv();
    if (!env) return;

    env->CallVoidMethod(CGUIManager::jobject1, env->GetMethodID(
            env->GetObjectClass(CGUIManager::jobject1), "closeGUI", "(Lorg/json/JSONObject;I)V"
    ), pJobject, i);
}