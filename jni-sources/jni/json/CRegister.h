#ifndef BLACK_RUSSIA_CREGISTER_H
#define BLACK_RUSSIA_CREGISTER_H

#include "network/CNetGame.h"

class CRegister {
public:
    static void SendLoginPacket(char* password, int autoLogin) {
        RakNet::BitStream bsSend;
        bsSend.Write((uint8_t)  ID_CUSTOM_RPC);
        bsSend.Write((uint32_t) ID_REGISTER_RPC);

        bsSend.Write(autoLogin);

        uint16_t passLen = strlen(password);
        bsSend.Write(passLen);

        bsSend.Write(password, passLen);

        CNetGame::Instance()->getRakInterface()->Send(&bsSend, HIGH_PRIORITY, RELIABLE, 0);
    }
};

#endif //BLACK_RUSSIA_CREGISTER_H
