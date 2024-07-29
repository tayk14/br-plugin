#ifndef __TYPES_H__
#define __TYPES_H__



typedef unsigned short _PlayerID;
typedef unsigned short _VehicleID;

typedef unsigned short RW_OBJECTID;

#include "quaternion.h"
typedef struct _PLAYER_SPAWN_INFO
{
    uint8_t byteTeam;
    int iSkin;
    uint8_t unk;
    VECTOR vecPos;
    float fRotation;
    int iSpawnWeapons[3];
    int iSpawnWeaponsAmmo[3];
} PLAYER_SPAWN_INFO;


typedef struct _ONFOOT_SYNC_DATA
{
    uint16_t lrAnalog;				// +0
    uint16_t udAnalog;				// +2
    uint16_t wKeys;					// +4
    VECTOR vecPos;					// +6
    CQuaternion quat;				// +18
    uint8_t byteHealth;				// +34
    uint8_t byteArmour;				// +35
    uint8_t byteCurrentWeapon;		// +36
    uint8_t byteSpecialAction;		// +37
    VECTOR vecMoveSpeed;			// +38
    VECTOR vecSurfOffsets;			// +50
    uint16_t wSurfInfo;				// +62
    uint32_t dwAnimation;			// 64
} ONFOOT_SYNC_DATA;


#define PADDING(x,y) uint8_t x[y]

#pragma pack(1)
typedef struct _ENTITY_TYPE
{
    // ENTITY STUFF
    uint32_t vtable; 		// 0-4		;vtable
    PADDING(_pad91, 16);	// 4-20
    MATRIX4X4 *mat; 		// 20-24	;mat
    uintptr_t m_RwObject;	// 24 - 28
    PADDING(_pad92, 6);	// 28-34
    uint16_t nModelIndex; 	// 34-36	;ModelIndex
    PADDING(_pad93, 32);	// 36-68
    VECTOR vecMoveSpeed; 	// 68-80	;vecMoveSpeed
    VECTOR vecTurnSpeed; 	// 80-92	;vecTurnSpeed
    PADDING(_pad94, 88);	// 92-180
    uintptr_t dwUnkModelRel; // 180-184 ;����� ����

} ENTITY_TYPE;

#pragma pack(1)
typedef struct _WEAPON_SLOT_TYPE
{
    uint32_t dwType;
    uint32_t dwState;
    uint32_t dwAmmoInClip;
    uint32_t dwAmmo;
    PADDING(_pwep1,12);
} WEAPON_SLOT_TYPE;  // MUST BE EXACTLY ALIGNED TO 28 bytes

#pragma pack(push, 1)

enum ePrimaryTasks //array indexes
{
    TASK_PRIMARY_PHYSICAL_RESPONSE = 0,
    TASK_PRIMARY_EVENT_RESPONSE_TEMP,
    TASK_PRIMARY_EVENT_RESPONSE_NONTEMP,
    TASK_PRIMARY_PRIMARY,
    TASK_PRIMARY_DEFAULT,
    TASK_PRIMARY_MAX
};

enum eSecondaryTasks //array indexes
{
    TASK_SECONDARY_ATTACK = 0,                // want duck to be after attack
    TASK_SECONDARY_DUCK,                    // because attack controls ducking movement
    TASK_SECONDARY_SAY,
    TASK_SECONDARY_FACIAL_COMPLEX,
    TASK_SECONDARY_PARTIAL_ANIM,
    TASK_SECONDARY_IK,
    TASK_SECONDARY_MAX
};

class CTaskManager
{
public:
    void* m_aPrimaryTasks[5];
    void* m_aSecondaryTasks[6];
    class CPed* m_pPed;
};

class CPedIntelligence
{
public:
    class CPed* m_pPed;
    CTaskManager   m_TaskMgr;
};

#pragma pack(1)
typedef struct _PED_TYPE
{
    ENTITY_TYPE entity; 		// 0000-0184	;entity
    PADDING(_pad106, 174);		// 0184-0358
    uint32_t _pad107;			// 0358-0362	;dwPedType
    PADDING(_pad101, 722);		// 0362-1084
    CPedIntelligence* pPedIntelligence; // 1084-1088
    PADDING(_pad100, 8);		// 1088-1096
    uint32_t dwAction;			// 1096-1100	;Action
    PADDING(_pad102, 52);		// 1100-1152
    uint32_t dwStateFlags; 		// 1152-1156	;StateFlags

    uintptr_t dwInvulFlags; // 1136-1140		0x1000 = can_decap
    PADDING(_pad228, 8); // 1140-1148
    uintptr_t Tasks; // 1148-1152
    uintptr_t dwPlayerInfoOffset; // 1152-1156

    PADDING(_pad103, 168);		// 1156-1344
    float fHealth;		 		// 1344-1348	;Health
    float fMaxHealth;			// 1348-1352	;MaxHealth
    float fArmour;				// 1352-1356	;Armour
    float fAim;
    PADDING(_pad104, 8);		// 1356-1368
    float fRotation1;			// 1368-1372	;Rotation1
    float fRotation2;			// 1372-1376	;Rotation2
    PADDING(_pad105, 44);		// 1376-1420
    uint32_t pVehicle;			// 1420-1424	;pVehicle
    PADDING(_pad108, 8);		// 1424-1432
    uint32_t dwPedType;			// 1432-1436	;dwPedType
    uint32_t dwUnk1;	 // 1436-1440
    WEAPON_SLOT_TYPE WeaponSlots[13]; // 1440-1804
    PADDING(_pad270, 12); // 1804-1816
    uint8_t byteCurWeaponSlot; // 1816-1817
    PADDING(_pad280, 23); // 1817-1840
    uint32_t pFireObject;	 // 1840-1844
    PADDING(_pad281, 44); // 1844-1888
    uint32_t  dwWeaponUsed; // 1888-1892
    uintptr_t pdwDamageEntity; // 1892-1896
} PED_TYPE;

typedef unsigned short VEHICLEID;

typedef struct _NEW_VEHICLE
{
    VEHICLEID 	VehicleID;
    int 		iVehicleType;
    VECTOR		vecPos;
    float 		fRotation;
    uint8_t		aColor1;
    uint8_t		aColor2;
    float		fHealth;
    uint8_t		byteInterior;
    uint32_t	dwDoorDamageStatus;
    uint32_t 	dwPanelDamageStatus;
    uint8_t		byteLightDamageStatus;
    uint8_t		byteTireDamageStatus;
    uint8_t		byteAddSiren;
    uint8_t		byteModSlots[14];
    uint8_t	  	bytePaintjob;
    int	cColor1;
    int	cColor2;
} NEW_VEHICLE;

#endif