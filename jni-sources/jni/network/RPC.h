#ifndef __RPC_H__
#define __RPC_H__

void ServerJoin(RPCParameters *rpcParams);
void ServerQuit(RPCParameters *rpcParams);
void InitGame(RPCParameters *rpcParams);
void WorldPlayerAdd(RPCParameters *rpcParams);
void WorldPlayerDeath(RPCParameters *rpcParams);
void WorldPlayerRemove(RPCParameters *rpcParams);
void WorldVehicleAdd(RPCParameters *rpcParams);
void WorldVehicleRemove(RPCParameters *rpcParams);
void ConnectionRejected(RPCParameters *rpcParams);
void ClientMessage(RPCParameters *rpcParams);
void Chat(RPCParameters *rpcParams);
void UpdateScoresPingsIPs(RPCParameters *rpcParams);
void ScrInitMenu(RPCParameters *rpcParams);
void ScrDialogBox(RPCParameters *rpcParams);
void ScrGameText(RPCParameters *rpcParams);
void ScrPlayAudioStream(RPCParameters *rpcParams);
void RegisterRPCs(RakClientInterface *pRakClient);


#endif