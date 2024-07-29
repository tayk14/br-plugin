#pragma once

#pragma pack(1)

#include <stdint.h>

typedef struct _VECTOR
{
    float X,Y,Z;
} VECTOR, *PVECTOR;

#pragma pack(1)
typedef struct _MATRIX4X4
{
    VECTOR right;		// 0-12 	; r11 r12 r13
    uint32_t  flags;	// 12-16
    VECTOR up;			// 16-28	; r21 r22 r23
    float  pad_u;		// 28-32
    VECTOR at;			// 32-44	; r31 r32 r33
    float  pad_a;		// 44-48
    VECTOR pos;			// 48-60
    float  pad_p;		// 60-64
} MATRIX4X4, *PMATRIX4X4;

class CQuaternion
{
public:
	CQuaternion() : w(1), x(0), y(0), z(0) {};
	CQuaternion(float _x, float _y, float _z, float _w) : x(_x), y(_y), z(_z), w(_w) {};

	void Set(float _x, float _y, float _z, float _w)
	{
		w = _w;
		x = _x;
		y = _y;
		z = _z;
	}

	void Set(CQuaternion q)
	{
		w = q.w;
		x = q.x;
		y = q.y;
		z = q.z;
	}

	void SetFromMatrix(MATRIX4X4 mat);
	void GetMatrix(PMATRIX4X4 mat);
	void Normalize();
	void Slerp(CQuaternion *pQ1, CQuaternion *pQ2, float t);

public:
	float w;
	float x;
	float y;
	float z;
};