#ifndef BLACK_RUSSIA_CGUIMANAGER_H
#define BLACK_RUSSIA_CGUIMANAGER_H


#include <jni.h>

class CGUIManager {
public:
    static jobject jobject1;

    static void ShowGUI(int i, jobject jobject2);
    static void HideGUI(int i, jobject pJobject);
    static JNIEnv * GetEnv();
};


#endif //BLACK_RUSSIA_CGUIMANAGER_H
