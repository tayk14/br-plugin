LOCAL_PATH := $(call my-dir)


include $(CLEAR_VARS)

APP_OPTIM := RELEASE

LOCAL_MODULE := pluginbr
LOCAL_LDLIBS := -llog -landroid

LOCAL_C_INCLUDES += $(wildcard $(LOCAL_PATH)/vendor/)
LOCAL_C_INCLUDES += $(wildcard $(LOCAL_PATH)/vendor/raknet/)

# pluginbr
FILE_LIST := $(wildcard $(LOCAL_PATH)/*.cpp)
FILE_LIST += $(wildcard $(LOCAL_PATH)/json/*.cpp)
FILE_LIST += $(wildcard $(LOCAL_PATH)/util/*.cpp)
FILE_LIST += $(wildcard $(LOCAL_PATH)/network/*.cpp)
FILE_LIST += $(wildcard $(LOCAL_PATH)/vendor/*.cpp)
FILE_LIST += $(wildcard $(LOCAL_PATH)/vendor/**/*.cpp)
FILE_LIST += $(wildcard $(LOCAL_PATH)/vendor/**/**/*.cpp)
FILE_LIST += $(wildcard $(LOCAL_PATH)/vendor/**/**/**/*.cpp)

FILE_LIST += $(wildcard $(LOCAL_PATH)/../santrope-tea-gtasa/encryption/*.cpp)
FILE_LIST += $(wildcard $(LOCAL_PATH)/../santrope-tea-gtasa/encryption/*.c)

LOCAL_SRC_FILES := $(FILE_LIST:$(LOCAL_PATH)/%=%)
LOCAL_CPPFLAGS := -w -s -fvisibility=hidden -pthread -Wall -fpack-struct=1 -O2 -std=c++14 -fexceptions
include $(BUILD_SHARED_LIBRARY)