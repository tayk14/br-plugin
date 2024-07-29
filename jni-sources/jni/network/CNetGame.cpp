#include <thread>

#include "CNetGame.h"
#include "RPC.h"
#include "AuthTable.h"
#include "utils.h"
#include "SAMP/SAMPRPC.h"
#include "obfuscate/str_obfuscate.hpp"
#include "scripting.h"

#define SAMP_VERSION	"0.3.7"

#define MAX_PLAYERS		1004

#define RAKSAMP_CLIENT
#define NETCODE_CONNCOOKIELULZ 0x6969

#define NETGAME_VERSION 4057
#define AUTH_BS "E02262CF28BC542486C558D4BE9EFB716592AFAF8B"
#define CLIENT_AUTH OBFUSCATE("00112233445566778899FFFFFFFFFFFFFFFF")
// 43
#define AUTH_BS "10B3D2B1317ADD02CC1F680BC500A8BC0FD7AD42CE7"

CNetGame* CNetGame::m_SingletonInstance = nullptr;

char* CNetGame::m_szHostOrIp;
char* CNetGame::m_szNickName;

CNetGame::CNetGame()
{
    m_rakClientInterface = RakNetworkFactory::GetRakClientInterface();
    RegisterRPCs(m_rakClientInterface);
}

CNetGame::~CNetGame()
{
    RakNetworkFactory::DestroyRakClientInterface(m_rakClientInterface);
}

void CNetGame::DbgConnect(char* nickname)
{
    m_rakClientInterface->Connect((char*)OBFUSCATE("127.0.0.1"), 7777, 0, 0, 5); // Balika
    m_szHostOrIp = (char*)OBFUSCATE("127.0.0.1");
    m_szNickName = nickname;
    // m_rakClientInterface->Connect("192.168.0.35", 7777, 0, 0, 0); // Sasuke
}

unsigned int GetTickCount()
{
    struct timeval tv;
    if(gettimeofday(&tv, NULL) != 0)
        return 0;

    return (tv.tv_sec * 1000) + (tv.tv_usec / 1000);
}

// =================================================================================================

extern void gen_auth_key(char buf[260], char* auth_in);
extern uintptr_t g_libBR;
extern uintptr_t g_libGTASA;
extern uint8_t g_pCurActivePlayer;

uint8_t byte_7BC633;

int sub_791A0(uintptr_t *a1, Packet* a2)
{
    RakNet::BitStream bsAuth((unsigned char *)a2->data, a2->length, false);

    uint8_t byteAuthLen;
    char szAuth[260];

    bsAuth.IgnoreBits(8);
    bsAuth.Read(byteAuthLen);
    bsAuth.Read(szAuth, byteAuthLen);
    szAuth[byteAuthLen] = '\0';

    char szAuthKey[260];
    gen_auth_key(szAuthKey, szAuth);

    RakNet::BitStream bsKey;
    uint8_t byteAuthKeyLen = (uint8_t)strlen(szAuthKey);

    bsKey.Write((uint8_t)ID_AUTH_KEY);
    bsKey.Write((uint8_t)byteAuthKeyLen);
    bsKey.Write(szAuthKey, byteAuthKeyLen);
    /*
    RakNet::BitStream *bitStream, PacketPriority priority, PacketReliability reliability, char orderingChannel
    */
    //(*(void (__fastcall **)(uintptr_t, RakNet::BitStream *bitStream, PacketPriority priority, PacketReliability reliability, char orderingChannel))(*(uintptr_t *)((*a1) + 32)))(*a1, &bsKey, SYSTEM_PRIORITY, RELIABLE, 0);
    CNetGame::Instance()->m_rakClientInterface->Send(&bsKey, SYSTEM_PRIORITY, RELIABLE, 0);

    LOG(OBFUSCATE("AUTH_KEY IN = %s; OUT = %s"), (char*) (a2->data + 2), szAuthKey);

    return 0;
}

#include "json/CJSONObject.h"
#include "json/CGUIManager.h"

void TestCustomRPC(Packet *p) {
    RakNet::BitStream bs((unsigned char*)p->data, p->length, false);
    uint8_t packetID;
    uint32_t rpcID;
    bs.Read(packetID);
    bs.Read(rpcID);

    LOG(OBFUSCATE("Get custom RPC"));

    switch (rpcID) {
        case 1000: {
            CJSONObject cjsonObject(CGUIManager::GetEnv());
            CGUIManager::HideGUI(38, cjsonObject.getMainObject());
            break;
        }
    }
}

extern void (*CNetGame__UpdateNetowrk)(uintptr_t *a1);
extern uintptr_t g_BRRakClient;
int sub_77A08(uintptr_t *a1) {
    Packet *v2; // r6
    char *v3; // r8
    unsigned int *v4; // r2
    int v5; // r1
    unsigned int *v6; // r12
    int v7; // r1
    uint8_t *v8; // r0
    int v9; // r5
    char *v10; // r11
    int *v11; // r5
    int v12; // r8
    int v13; // r9
    bool v14; // zf
    int v16; // r0
    int v17; // r9
    int v18; // r5
    int v19; // r8
    int v20; // r0
    int v21; // r3
    uintptr_t *v22; // r8
    int v23; // r5
    uintptr_t *v24; // r8
    int v25; // r5
    int v26; // r5
    void *v27; // r0
    char v28; // r0
    int v29; // r5
    char v30; // r5
    void *v31; // r0
    int v33; // [sp+0h] [bp-2A0h]
    int v34; // [sp+0h] [bp-2A0h]
    int v35; // [sp+4h] [bp-29Ch]
    int v36; // [sp+4h] [bp-29Ch]
    int v37; // [sp+8h] [bp-298h]
    int v38; // [sp+8h] [bp-298h]
    int v39; // [sp+78h] [bp-228h] BYREF
    int v40[136]; // [sp+80h] [bp-220h] BYREF

    int isCustomPcktId = 0;

//    if(*(uint8_t*)(g_libGTASA + 0x5D1B24) != g_pCurActivePlayer){ *(uint8_t*)(g_libGTASA + 0x5D1B24) = g_pCurActivePlayer; }

    static bool once = false;
    if (!once) {
        *(char *) (g_libBR + 0x7BC620) = 0;
        once = true;
    }

    if (!*(uintptr_t *) (g_libBR + 0x7F8C00))
        *(uintptr_t *) (g_libBR + 0x7F8C00) = GetTickCount();

    if (!a1 || !*a1) {
        return 0;
    }

    //Packet* pPacket = CNetGame::Instance()->m_rakClientInterface->Receive();
    v2 = ((RakClientInterface *) (*a1))->Receive();
    if (v2) {
//        if(v2->data[0]>=200){
//            *a1 = g_BRRakClient;
//            CNetGame__UpdateNetowrk(a1);
//            return 0;
//        }
        v3 = (char *) v34;
        while (1) {
            v8 = v2->data;
            v9 = v8[0];
            if (v9 == 40)
                v9 = v8[5];
            *(uintptr_t *) (g_libBR + 0x7F8C00) = GetTickCount();
            LOG(OBFUSCATE("CNetGame | packet  : %i"), v9);
            switch (v9) {
                case 200:
                    ((uintptr_t(*)(uintptr_t *, uintptr_t *)) (g_libBR + 0x078948 + 1))(a1,
                                                                                        (uintptr_t *) v2);
                    goto LABEL_80;
                case 201:
                case 202:
                case 204:
                case 205:
                case 212:
                case 213:
                case 214:
                case 215:
                case 216:
                case 217:
                case 218:
                case 219:
                case 220:
                case 221:
                case 222:
                case 223:
                case 224:
                case 225:
                case 226:
                case 227:
                case 228:
                case 229:
                case 230:
                case 231:
                case 232:
                case 233:
                case 234:
                case 235:
                case 236:
                case 237:
                case 238:
                case 239:
                case 240:
                case 241:
                case 242:
                case 243:
                case 244:
                case 245:
                case 246:
                case 247:
                case 248:
                case 249:
                case 250:
                case 251:
                    TestCustomRPC(v2);
//                    goto LABEL_80;
                case 203:
                    ((uintptr_t(*)(uintptr_t *, uintptr_t *)) (g_libBR + 0x079130 + 1))(a1,
                                                                                        (uintptr_t *) v2);
                    goto LABEL_80;
                case 206:
                    ((uintptr_t(*)(uintptr_t *, uintptr_t *)) (g_libBR + 0x0791D0 + 1))(a1,
                                                                                        (uintptr_t *) v2);
                    goto LABEL_80;
                case 207:
                    ((uintptr_t(*)(uintptr_t *, uintptr_t *)) (g_libBR + 0x0786E4 + 1))(a1,
                                                                                        (uintptr_t *) v2);
                    goto LABEL_80;
                case 208:
                    ((uintptr_t(*)(uintptr_t *, uintptr_t *)) (g_libBR + 0x078FF4 + 1))(a1,
                                                                                        (uintptr_t *) v2);
                    goto LABEL_80;
                case 209:
                    ((uintptr_t(*)(uintptr_t *, uintptr_t *)) (g_libBR + 0x078D8C + 1))(a1,
                                                                                        (uintptr_t *) v2);
                    goto LABEL_80;
                case 210:
                    ((uintptr_t(*)(uintptr_t *, uintptr_t *)) (g_libBR + 0x078BE4 + 1))(a1,
                                                                                        (uintptr_t *) v2);
                    goto LABEL_80;
                case 211:
                    ((uintptr_t(*)(uintptr_t *, uintptr_t *)) (g_libBR + 0x078F5C + 1))(a1,
                                                                                        (uintptr_t *) v2);
                    goto LABEL_80;
                case 252:
                    ((uintptr_t(*)(uintptr_t *, uintptr_t *)) (g_libBR + 0x079274 + 1))(a1,
                                                                                        (uintptr_t *) v2);
                    goto LABEL_80;
                case 253:
                    ((uintptr_t(*)(uintptr_t *, uintptr_t *)) (g_libBR + 0x0793E4 + 1))(a1,
                                                                                        (uintptr_t *) v2);
                    goto LABEL_80;
                default:
                    switch (v9) {
                        case 12:
                            LOG(OBFUSCATE("Incoming packet: ID_AUTH_KEY"));
                            //((void (*)(uintptr_t*, uintptr_t))(g_libBR + 0x0791A0 + 1))(a1, *(uintptr_t*)(uintptr_t*)v2);
                            sub_791A0(a1, v2);
                            LOG(OBFUSCATE("CNetGame | packet Id : %i | 0"), v9);
                            goto LABEL_80;
                        case 29:
//                            strcpy(v3, (char *) OBFUSCATE(
//                                    "Отсутствует соединение. Для решения: попробуйте перезагрузить роутер, либо сменить интернет, либо воспользоваться VPN"));
//                if ( (*(uint8_t*)(byte_7BC633))++ > 1u )
//                {
//                    *(char*)(byte_7BC633) = 0;
//                    *(char*)(g_libBR + 0x7BC630) = 0;
//                    if ( *(char*)(g_libBR + 0x7BC632) != 1 )
//                        goto LABEL_78;
//                }
//                else if ( !*(char*)g_libBR + 0x7BC632 ){*(char*)(byte_7BC633) = 0;*(char*)(g_libBR + 0x7BC630) = 0;LABEL_78:*(char*)(g_libBR + 0x7BC632) = 1;goto LABEL_79;}
                            LOG(OBFUSCATE("CNetGame | packet Id : %i | 1"), v9);
//                            ((uintptr_t(*)(uintptr_t *, uintptr_t, char *)) (g_libBR + 0x01DACC + 1))(
//                                    *(uintptr_t **) (g_libBR + 0x20533C), 0xBEBEBEFF, v3);
                        LABEL_79:
                            a1[10] = 9;
                        LABEL_80:
                            LOG(OBFUSCATE("CNetGame | packet Id : %i | 2"), v9);
                            ((RakClientInterface *) (*a1))->DeallocatePacket(v2);
                            v2 = ((RakClientInterface *) (*a1))->Receive();
//                            CNetGame::Instance()->m_rakClientInterface->DeallocatePacket(pPacket);
//                            pPacket = CNetGame::Instance()->m_rakClientInterface->Receive();
//                            v2 = pPacket;
//                            TestCustomRPC(v2);
                            LOG(OBFUSCATE("CNetGame | packet Id : %i | 3"), v9);
                            if (!v2) {
                                LOG(OBFUSCATE("CNetGame | empty packet"));
                                return 1;
                            }
                            break;
                        case 31:
                            v10 = v3;
                            //((uintptr_t(*)(uintptr_t*, uintptr_t, char))(g_libBR + 0x1DACC))(*(uintptr_t**)g_libBR + 0x20533C, 0xBEBEBEFF, *(char*)(g_libBR + 0x1CF74C));
                            a1[10] = 9;
                            v11 = (int *) *(uintptr_t *) (g_libBR + 0x207F24);
                            *(char *) (byte_7BC633) = 10;
                            v12 = *(uintptr_t *) *(uintptr_t *) (g_libBR + 0x207F24);
                            if (!*(uintptr_t *) *(uintptr_t *) (g_libBR + 0x207F24)) {
                                v12 = *(uintptr_t *) operator new(0x28Au);
                                ((void (*)()) (g_libBR + 0x05212C))();
                                *v11 = v12;
                                v11 = (int *) *(uintptr_t *) (g_libBR + 0x207F24);
                            }
                            v13 = *(int *) ((char *) v11 + 5);
                            v14 = v13 == 0;
                            if (v13)
                                v14 = v12 == 0;
                            if (!v14 && !*(char *) (g_libBR + 0x7BC620)) {
                                if (((int (*)(int)) (g_libBR + 0x052A26 + 1))(v12) == 1)
                                    ((uintptr_t(*)(uintptr_t, float, float, float)) (g_libBR +
                                                                                     0x052994 + 1))(
                                            v12,
                                            429.63,
                                            240.1,
                                            12.9);
                                else
                                    ((void (__fastcall *)(int, float, float, float)) (g_libBR +
                                                                                      0x043010 +
                                                                                      1))(
                                            v12, 429.63, 240.1, 12.9);
                                ((uintptr_t(*)(uintptr_t)) (g_libBR + 0x04107C))(v13);
                                ((uintptr_t(*)(uintptr_t)) (g_libBR + 0x04103C))(v13);
                                ((uintptr_t(*)(uintptr_t, int)) (g_libBR + 0x053170))(v12, 1);
                                ((uintptr_t(*)(uintptr_t, int)) (g_libBR + 0x052544))(v12, 122);
                                ((uintptr_t(*)(uintptr_t, int)) (g_libBR + 0x04457C))(
                                        *(uintptr_t *) (g_libBR + 0x207F24), 1);
                                ((uintptr_t(*)(uintptr_t, int)) (g_libBR + 0x0445F4))(
                                        *(uintptr_t *) (g_libBR + 0x207F24), 0);
                                v16 = time(0);
                                srand48(v16);
                                v17 = (*(uintptr_t **) (g_libBR + 0x1D6D50))[lrand48() % 0xFu];
                                if (!((int (*)(uintptr_t, uintptr_t)) (g_libBR + 0x04461C))(
                                        *(uintptr_t *) (g_libBR + 0x207F24), v17)) {
                                    ((uintptr_t(*)(uintptr_t, uintptr_t, int)) (g_libBR +
                                                                                0x043C40))(
                                            *(uintptr_t *) (g_libBR + 0x207F24), v17, 2);
                                    ((uintptr_t(*)(uintptr_t)) (g_libBR + 0x043C88))(
                                            *(uintptr_t *) (g_libBR + 0x207F24));
                                }
                                ((void (__fastcall *)(void *, ...)) (g_libBR + 0x055814 + 1))(
                                        &*(uintptr_t *) g_libBR + 0x1D6D8C,
                                        v17,
                                        0x80000000,
                                        3.9196,
                                        2.0,
                                        3.7189,
                                        -2.0);
                                ((uintptr_t(*)(uintptr_t *, ...)) (
                                        g_libBR + 0x055814 + 1))(&*(uintptr_t *) g_libBR + 0x1D6D9E,
                                                                 *(uintptr_t *) g_libBR + 0x201EDC,
                                                                 1, 1, 1,
                                                                 1, 1);
                                v18 = *(uintptr_t *) g_libBR + 0x201EDC;
                                v19 = lrand48() % 256;
                                v20 = lrand48();
                                ((uintptr_t(*)(uintptr_t *, ...)) (
                                        g_libBR + 0x055814 + 1))(&*(uintptr_t *) g_libBR + 0x1D6DB0,
                                                                 v18,
                                                                 v19, v20 % 256, v33, v35, v37);
                                v22 = (uintptr_t *) *(uintptr_t *) (g_libBR + 0x207F24);
                                v23 = *(uintptr_t *) *(uintptr_t *) (g_libBR + 0x207F24);
                                if (!*(uintptr_t *) *(uintptr_t *) (g_libBR + 0x207F24)) {
                                    v23 = *(uintptr_t *) operator new(0x28Au);
                                    ((uintptr_t(*)()) (g_libBR + 0x05212C))();
                                    *v22 = v23;
                                }
                                ((uintptr_t(*)(uintptr_t *, ...)) (
                                        g_libBR + 0x055814 + 1))(&*(uintptr_t *) g_libBR + 0x1D6DC2,
                                                                 *(uintptr_t *) (v23 + 8),
                                                                 *(uintptr_t *) g_libBR + 0x201EDC,
                                                                 v21,
                                                                 v34, v36, v38);
                                v24 = *(uintptr_t **) ((g_libBR + 0x207F24));
                                v25 = *(uintptr_t *) ((g_libBR + 0x207F24));
                                if (!*(uintptr_t *) ((g_libBR + 0x207F24))) {
                                    v25 = *(uintptr_t *) operator new(0x28Au);
                                    ((uintptr_t(*)()) (g_libBR + 0x05212C))();
                                    *v24 = v25;
                                }
                                ((uintptr_t(*)(uintptr_t *, ...)) (
                                        g_libBR + 0x055814 + 1))(&*(uintptr_t *) g_libBR + 0x1D6D3C,
                                                                 *(uintptr_t *) (v25 + 8), 1, 1, 1,
                                                                 1, 1);
                                ((uintptr_t(*)(uintptr_t, uintptr_t, int)) (g_libBR + 0x043CF0))(
                                        *(uintptr_t *) (g_libBR + 0x207F24), v17, 0);
                                ((uintptr_t(*)(uintptr_t *, char *, int)) (g_libBR + 0x08EF64 + 1))(
                                        &*(uintptr_t *) g_libBR + 0x1CF772, v10, 500);
                                v26 = *(uintptr_t *) (g_libBR + 0x7BEE6C);
                                ((uintptr_t(*)(uintptr_t, char *)) (g_libBR + 0x190218))(
                                        (uintptr_t) &v39, v10);
                                ((uintptr_t(*)(uintptr_t, int, uintptr_t *)) (g_libBR + 0x08D9F6))(
                                        v26,
                                        39,
                                        (uintptr_t *) &v39);
                                v27 = (void *) (v39 - 12);
                                if ((uintptr_t *) (v39 - 12) !=
                                    &*(uintptr_t *) (g_libBR + 0x7E7E40)) {
                                    v4 = (unsigned int *) (v39 - 4);
                                }
                                *(char *) (g_libBR + 0x7BC620) = 1;
                            }
                            v3 = v10;
                            v28 = *(char *) g_libBR + 0x7BC638;
                            if ((v28 & 1) == 0 && &*(char *) g_libBR + 0x7BC638) {
                                v29 = *(uintptr_t *) (g_libBR + 0x7BEE6C);
                                ((uintptr_t(*)(uintptr_t, char *)) (g_libBR + 0x190218))((int) v10,
                                                                                         (char *) *(uintptr_t *) g_libBR +
                                                                                         0x207F50);
                                v30 = ((uintptr_t(*)(uintptr_t, char *)) (g_libBR + 0x08E690))(v29,
                                                                                               v10);
                                v31 = (void *) (v40[0] - 12);
                                *(char *) (g_libBR + 0x7BC634) = v30;
                            }
                            if (*(char *) (g_libBR + 0x7BC634))
                                a1[11] = 0;
                            goto LABEL_80;
                        case 32:
                            if (*(uintptr_t *) (g_libBR + 0x20533C))
                                //((uintptr_t(*)(uintptr_t, uintptr_t, uintptr_t))(g_libBR + 0x01DACC))(*(uintptr_t*)g_libBR + 0x20533C, 0xBEBEBEFF, *(uintptr_t*)g_libBR + 0x1CF8F2);
                                CNetGame::Instance()->m_rakClientInterface->Disconnect(2000, 0);
                            //((uintptr_t(*)())(g_libBR + 0x08D9B8 + 1))();
                            if (*(uintptr_t *) g_libBR + 0x207F40)
                                ((uintptr_t(*)(uintptr_t)) (g_libBR + 0x09C72C))(
                                        *(uintptr_t *) g_libBR + 0x207F40);
                            if (*(uintptr_t *) g_libBR + 0x609F68)
                                ((uintptr_t(*)(uintptr_t)) (g_libBR + 0x04006C))(
                                        *(uintptr_t *) g_libBR + 0x609F68);
                            goto LABEL_80;
                        case 33:
                            ((uintptr_t(*)(uintptr_t *)) (g_libBR + 0x07931C + 1))(a1);
                            goto LABEL_80;
                        case 34:
                            CNetGame::bConnected = true;
                            CNetGame::Instance()->Packet_ConnectionSucceeded(v2);
                            goto LABEL_80;
                        case 35:
//                            ((uintptr_t(*)(uintptr_t, char *)) (g_libBR + 0x01DA3C))(
//                                    *(uintptr_t *) (g_libBR + 0x20533C),
//                                    (char *) OBFUSCATE("Failed to initialize encryption."));
                            goto LABEL_80;
                        case 36:/*((uintptr_t(*)(uintptr_t,uintptr_t,char*))(g_libBR + 0x01DACC))(*(uintptr_t*)g_libBR + 0x20533C, 0xBEBEBEFF, (char *)*(uintptr_t*)g_libBR + 0x79064);*/
                            goto LABEL_80;
                        case 37:
//                            ((uintptr_t(*)(uintptr_t, char *)) (g_libBR + 0x01DA3C))(
//                                    *(uintptr_t *) g_libBR + 0x20533C,
//                                    (char *) OBFUSCATE("Wrong server password"));
                            CNetGame::Instance()->m_rakClientInterface->Disconnect(0, 0);
                            goto LABEL_80;
                        default:
                            goto LABEL_80;
                    }
                    break;
            }
        }
    }

//    LOG(OBFUSCATE("CNetGame | zalupa 3"));

    return 0;
}

// =================================================================================================

unsigned int lastOnFootSyncTick = 0;
extern int iNetModeNormalOnfootSendRate;

bool CNetGame::bConnected = false;
void CNetGame::Process()
{
    Packet* pPacket = 0;
    while((pPacket = m_rakClientInterface->Receive()))
    {
        int v9 = pPacket->data[0];
        LOG(OBFUSCATE("Packet received -> %d\n"), v9);

        switch(v9)
        {
            case ID_AUTH_KEY:
                LOG(OBFUSCATE("Incoming packet: ID_AUTH_KEY"));
                Packet_AUTH_KEY(pPacket);
                break;

            case ID_CONNECTION_ATTEMPT_FAILED:
                //pChatWindow->AddDebugMessageNonFormatted(CLocalisation::GetMessage(E_MSG::CONNECTION_ATTEMPT_FAILED));
                //SetGameState(GAMESTATE_WAIT_CONNECT);
                break;

            case ID_NO_FREE_INCOMING_CONNECTIONS:
                //pChatWindow->AddDebugMessageNonFormatted(CLocalisation::GetMessage(E_MSG::FULL_SERVER));
                //SetGameState(GAMESTATE_WAIT_CONNECT);
                break;

            case ID_DISCONNECTION_NOTIFICATION:
                break;

            case ID_CONNECTION_LOST:
                break;

            case ID_CONNECTION_REQUEST_ACCEPTED:
                CNetGame::bConnected = true;
                Packet_ConnectionSucceeded(pPacket);
                break;

            case ID_FAILED_INITIALIZE_ENCRIPTION:
                //pChatWindow->AddDebugMessage(OBFUSCATE("Failed to initialize encryption."));
                break;

                // fixed
            case ID_CONNECTION_BANNED:
                ////pChatWindow->AddDebugMessageNonFormatted(CLocalisation::GetMessage(E_MSG::BANNED));
                //SetGameState(GAMESTATE_WAIT_CONNECT);
                break;

            case ID_INVALID_PASSWORD:
                //pChatWindow->AddDebugMessage(OBFUSCATE("Incorrect Server Password."));
                m_rakClientInterface->Disconnect(0);
                break;

            case ID_PLAYER_SYNC:

                break;

            case ID_VEHICLE_SYNC:

                break;

            case ID_PASSENGER_SYNC:

                break;

            case ID_MARKERS_SYNC:

                break;

            case ID_AIM_SYNC:

                break;

            case ID_BULLET_SYNC:

                break;

            case ID_TRAILER_SYNC:

                break;

            case ID_CUSTOM_RPC:

                break;
        }

        m_rakClientInterface->DeallocatePacket(pPacket);
    }

    if (m_isInGame && iNetModeNormalOnfootSendRate > 0 && lastOnFootSyncTick < (GetTickCount() - iNetModeNormalOnfootSendRate))
    {

        lastOnFootSyncTick = GetTickCount();
    }
}


RakClientInterface* CNetGame::getRakInterface()
{
    return m_rakClientInterface;
}


void CNetGame::Packet_AUTH_KEY(Packet *p)
{
    RakNet::BitStream bsAuth((unsigned char *)p->data, p->length, false);

    uint8_t byteAuthLen;
    char szAuth[260];

    bsAuth.IgnoreBits(8);
    bsAuth.Read(byteAuthLen);
    bsAuth.Read(szAuth, byteAuthLen);
    szAuth[byteAuthLen] = '\0';

    char szAuthKey[260];
    gen_auth_key(szAuthKey, szAuth);

    RakNet::BitStream bsKey;
    uint8_t byteAuthKeyLen = (uint8_t)strlen(szAuthKey);

    bsKey.Write((uint8_t)ID_AUTH_KEY);
    bsKey.Write((uint8_t)byteAuthKeyLen);
    bsKey.Write(szAuthKey, byteAuthKeyLen);
    m_rakClientInterface->Send(&bsKey, SYSTEM_PRIORITY, RELIABLE, 0);

    LOG(OBFUSCATE("AUTH_KEY IN = %s; OUT = %s"), (char*) (p->data + 2), szAuthKey);
}

#define SEND_RPC(networkObject, functionName, packet) { int rpcid = (RPC_##functionName); (networkObject)->RPC(&rpcid, &packet, HIGH_PRIORITY, RELIABLE, 0, FALSE, UNASSIGNED_NETWORK_ID, NULL); }
#include <stdlib.h>
#include <sstream>

void CNetGame::Packet_ConnectionSucceeded(Packet* pkt)
{
    RakNet::BitStream bsSuccAuth((unsigned char *)pkt->data, pkt->length, false);
    unsigned short MyPlayerID;
    unsigned int uiChallenge;

    bsSuccAuth.IgnoreBits(8); // ID_CONNECTION_REQUEST_ACCEPTED
    bsSuccAuth.IgnoreBits(32); // binaryAddress
    bsSuccAuth.IgnoreBits(16); // port
    bsSuccAuth.Read(MyPlayerID);
    bsSuccAuth.Read(uiChallenge);
    char ip[0x7F];
    strncpy(ip, m_szHostOrIp, sizeof(ip));

    std::vector<std::string> strings;
    std::istringstream f((const char*)&ip[0]);
    std::string s;
    int sum = 0;
    while (getline(f, s, '.'))
    {
        sum += atoi(s.c_str());
    }



//    if (g_isValidSum(sum))
//    {
//        WriteVerified1();
//    }
    //m_pPlayerPool->SetLocalPlayerID(MyPlayerID);

    int iVersion = NETGAME_VERSION;
    char byteMod = 0x01;
    unsigned int uiClientChallengeResponse = uiChallenge ^ iVersion;

    char byteAuthBSLen = (char)strlen(AUTH_BS);
    char byteNameLen = (char)strlen(m_szNickName);
    char byteClientverLen = (char)strlen(SAMP_VERSION);

    RakNet::BitStream bsSend;
    bsSend.Write(iVersion);
    bsSend.Write(byteMod);
    bsSend.Write(byteNameLen);
    bsSend.Write(m_szNickName, byteNameLen);
    bsSend.Write(uiClientChallengeResponse);
    bsSend.Write(byteAuthBSLen);
    bsSend.Write(AUTH_BS, byteAuthBSLen);
    bsSend.Write(byteClientverLen);
    bsSend.Write(SAMP_VERSION, byteClientverLen);

    m_rakClientInterface->RPC(&RPC_ClientJoin, &bsSend, HIGH_PRIORITY, RELIABLE, 0, false, UNASSIGNED_NETWORK_ID, NULL);
}

void CNetGame::SendDialogResponse(uint16_t wDialogID, uint8_t byteButtonID, uint16_t wListBoxItem, char* szInput)
{
    uint8_t respLen = strlen(szInput);

    RakNet::BitStream bsSend;
    bsSend.Write(wDialogID);
    bsSend.Write(byteButtonID);
    bsSend.Write(wListBoxItem);
    bsSend.Write(respLen);
    bsSend.Write(szInput, respLen);
    m_rakClientInterface->RPC(&RPC_DialogResponse, &bsSend, HIGH_PRIORITY, RELIABLE_ORDERED, 0, false, UNASSIGNED_NETWORK_ID, NULL);
}

void CNetGame::SendChatMessage(const char* szMsg)
{
    if (!m_isInGame) return;

    RakNet::BitStream bsSend;
    uint8_t byteTextLen = strlen(szMsg);

    bsSend.Write(byteTextLen);
    bsSend.Write(szMsg, byteTextLen);

    m_rakClientInterface->RPC(&RPC_Chat,&bsSend,HIGH_PRIORITY,RELIABLE,0,false, UNASSIGNED_NETWORK_ID, NULL);
}

void CNetGame::SendChatCommand(const char* szCommand)
{
    if (!m_isInGame) return;

    RakNet::BitStream bsParams;
    int iStrlen = strlen(szCommand);

    bsParams.Write(iStrlen);
    bsParams.Write(szCommand, iStrlen);
    m_rakClientInterface->RPC(&RPC_ServerCommand, &bsParams, HIGH_PRIORITY, RELIABLE, 0, false, UNASSIGNED_NETWORK_ID, NULL);
}

void CNetGame::RequestClass(int iClass)
{
    RakNet::BitStream bsSpawnRequest;
    bsSpawnRequest.Write(iClass);
    CNetGame::Instance()->m_rakClientInterface->RPC(&RPC_RequestClass, &bsSpawnRequest, HIGH_PRIORITY, RELIABLE, 0, false, UNASSIGNED_NETWORK_ID, 0);
}