//
// Created by gen1z on 02/03/2024.
//

#ifndef BLACK_RUSSIA_ORIGINAL_MAIN_H
#define BLACK_RUSSIA_ORIGINAL_MAIN_H


#include <android/log.h>
#include <fstream>
#include <sstream>
#include <iostream>
#include <strstream>
#include <utility>
#include <stdio.h>
#include <stdint.h>
#include <jni.h>
#include "util/util.h"
#include "obfuscate/str_obfuscate.hpp"

#define RAKSAMP_CLIENT

extern  uintptr_t g_libBR;
extern  uintptr_t g_libGTASA;

extern  uintptr_t* g_CNetGame;
extern  uintptr_t g_iGameState;

#define SA_ADDR(addr) (g_libGTASA + (addr))
#define GTA(addr) (g_libGTASA + (addr))


#include "network/main.hpp"

#define NETCODE_CONNCOOKIELULZ 0x6969


#endif //BLACK_RUSSIA_ORIGINAL_MAIN_H
