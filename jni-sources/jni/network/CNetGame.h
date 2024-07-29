#ifndef __CNETGAME_H__
#define __CNETGAME_H__

#include <iostream>
#include <time.h>
#include <random>

#include <RakClient.h>
#include <RakNetworkFactory.h>
#include <PacketEnumerations.h>
#include <StringCompressor.h>
#include "types.h"

void LOG(const char* fmt, ...);

#define UPDATE_TYPE_ONFOOT		1

#define SPECIAL_ACTION_ENTER_VEHICLE 	3
#define SPECIAL_ACTION_EXIT_VEHICLE 	4

#define PLAYER_STATE_ONFOOT						17

#define INVALID_PLAYER_ID 0xFFFF
#define INVALID_VEHICLE_ID 0xFFFF

typedef unsigned short VEHICLEID;
typedef unsigned short PLAYERID;

class CNetGame
{
/*private*/public: //TODO!!!
	static CNetGame*		m_SingletonInstance;
	RakClientInterface* 	m_rakClientInterface = nullptr;
	bool					m_isInGame = false;
	
public:

    bool				m_bShowNameTag;
    bool				m_bKeyboardOpened;
    float 				m_fReportedHealth;
    float 				m_fReportedArmour;

	CNetGame();
	~CNetGame();

	void DbgConnect(char* nickname);
	void Process();

    void SendDialogResponse(uint16_t wDialogID, uint8_t byteButtonID, uint16_t wListboxItem, char* szInput);
    void SendChatMessage(const char *szMsg);
	
	/* Packets */
	void Packet_AUTH_KEY(Packet *p);
	void Packet_ConnectionSucceeded(Packet *p);
	
	RakClientInterface* getRakInterface();
	
	static CNetGame* Instance()
	{
		if(m_SingletonInstance == nullptr)
		{
			m_SingletonInstance = new CNetGame();
		}
		return m_SingletonInstance;
	}

    static bool bConnected;
    static char* m_szHostOrIp;
    static char* m_szNickName;


    void SendChatCommand(const char *szCommand);

    void RequestClass(int iClass);
};

#endif