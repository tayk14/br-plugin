#include "jni.h"
#include "CJSONObject.h"
#include "CGUIManager.h"
#include "json/CRegister.h"

extern "C"
JNIEXPORT void JNICALL
Java_com_nvidia_devtech_NvEventQueueActivity_sendRegerdsJsonData(JNIEnv *env, jobject thiz,jint g_id, jbyteArray b) {
    CJSONObject cjsonObject(CGUIManager::GetEnv(), b);

    switch (g_id) {
        case 38: {
            switch (cjsonObject.getInt("t")) {
                case 6: { // авторизация
                    char* pass = const_cast<char *>(cjsonObject.getString("s"));
                    int isAutoLogin = cjsonObject.getInt("r");
                    CRegister::SendLoginPacket(pass, isAutoLogin);
                }
            }
            break;
        }
    }
}