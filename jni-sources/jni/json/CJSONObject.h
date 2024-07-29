#ifndef BLACK_RUSSIA_CJSONOBJECT_H
#define BLACK_RUSSIA_CJSONOBJECT_H

#include <jni.h>
#include <string>

class CJSONObject {
private:
    jobject jsonObject;
    JNIEnv *env;
    jclass jsonClass;

public:
    CJSONObject(JNIEnv *env) {
        this->env = env;
        this->jsonClass = env->FindClass("org/json/JSONObject");

        jmethodID init = env->GetMethodID(jsonClass, "<init>", "()V");
        this->jsonObject = env->NewObject(jsonClass, init);
    }

    CJSONObject(JNIEnv *env, jbyteArray jsonBytes) {
        this->env = env;
        this->jsonClass = env->FindClass("org/json/JSONObject");

        jsize length = env->GetArrayLength(jsonBytes);
        jbyte* byteArray = env->GetByteArrayElements(jsonBytes, JNI_FALSE);
        std::string jsonString(reinterpret_cast<char*>(byteArray), length);
        env->ReleaseByteArrayElements(jsonBytes, byteArray, JNI_ABORT);

        jmethodID init = env->GetMethodID(jsonClass, "<init>", "(Ljava/lang/String;)V");
        jstring jsonStringJStr = env->NewStringUTF(jsonString.c_str());
        this->jsonObject = env->NewObject(jsonClass, init, jsonStringJStr);
        env->DeleteLocalRef(jsonStringJStr);
    }

    ~CJSONObject() {
        if (jsonObject != nullptr) {
            env->DeleteLocalRef(jsonObject);
        }
    }

    void putString(const char *key, const char *value) {
        jmethodID putMethod = env->GetMethodID(jsonClass, "put", "(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;");
        jstring jkey = env->NewStringUTF(key);
        jstring jvalue = env->NewStringUTF(value);
        env->CallObjectMethod(jsonObject, putMethod, jkey, jvalue);
        env->DeleteLocalRef(jkey);
        env->DeleteLocalRef(jvalue);
    }

    void putInt(const char *key, int value) {
        jmethodID putMethod = env->GetMethodID(jsonClass, "put", "(Ljava/lang/String;I)Lorg/json/JSONObject;");
        jstring jkey = env->NewStringUTF(key);
        env->CallObjectMethod(jsonObject, putMethod, jkey, value);
        env->DeleteLocalRef(jkey);
    }

    void putBoolean(const char *key, bool value) {
        jmethodID putMethod = env->GetMethodID(jsonClass, "put", "(Ljava/lang/String;Z)Lorg/json/JSONObject;");
        jstring jkey = env->NewStringUTF(key);
        jboolean jvalue = value ? JNI_TRUE : JNI_FALSE;
        env->CallObjectMethod(jsonObject, putMethod, jkey, jvalue);
        env->DeleteLocalRef(jkey);
    }

    const char* getString(const char *key) {
        jmethodID getStringMethod = env->GetMethodID(jsonClass, "getString", "(Ljava/lang/String;)Ljava/lang/String;");
        jstring jkey = env->NewStringUTF(key);
        jstring jvalue = (jstring) env->CallObjectMethod(jsonObject, getStringMethod, jkey);
        const char* result = env->GetStringUTFChars(jvalue, nullptr);
        env->DeleteLocalRef(jkey);
        env->DeleteLocalRef(jvalue);
        return result;
    }

    int getInt(const char *key) {
        jmethodID getIntMethod = env->GetMethodID(jsonClass, "getInt", "(Ljava/lang/String;)I");
        jstring jkey = env->NewStringUTF(key);
        jint result = env->CallIntMethod(jsonObject, getIntMethod, jkey);
        env->DeleteLocalRef(jkey);
        return result;
    }

    bool getBoolean(const char *key) {
        jmethodID getBooleanMethod = env->GetMethodID(jsonClass, "getBoolean", "(Ljava/lang/String;)Z");
        jstring jkey = env->NewStringUTF(key);
        jboolean result = env->CallBooleanMethod(jsonObject, getBooleanMethod, jkey);
        env->DeleteLocalRef(jkey);
        return result == JNI_TRUE;
    }

    jobject getMainObject() {
        return jsonObject;
    }
};

#endif //BLACK_RUSSIA_CJSONOBJECT_H
