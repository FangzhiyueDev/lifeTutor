/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /media/fang/codeAndNote/developer/androidNew/androidProject/android/lifeTutor/aidltest/src/main/aidl/android/os/INetworkManagementService.aidl
 */
package android.os;
// Declare any non-default types here with import statements

public interface INetworkManagementService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements android.os.INetworkManagementService
{
private static final java.lang.String DESCRIPTOR = "android.os.INetworkManagementService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an android.os.INetworkManagementService interface,
 * generating a proxy if needed.
 */
public static android.os.INetworkManagementService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.os.INetworkManagementService))) {
return ((android.os.INetworkManagementService)iin);
}
return new android.os.INetworkManagementService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
java.lang.String descriptor = DESCRIPTOR;
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(descriptor);
return true;
}
case TRANSACTION_setFirewallUidChainRule:
{
data.enforceInterface(descriptor);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
boolean _arg2;
_arg2 = (0!=data.readInt());
this.setFirewallUidChainRule(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_clearFirewallChain:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
this.clearFirewallChain(_arg0);
reply.writeNoException();
return true;
}
default:
{
return super.onTransact(code, data, reply, flags);
}
}
}
private static class Proxy implements android.os.INetworkManagementService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void setFirewallUidChainRule(int uid, int networkType, boolean allow) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
_data.writeInt(networkType);
_data.writeInt(((allow)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setFirewallUidChainRule, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
//zrx add

@Override public void clearFirewallChain(java.lang.String chain) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(chain);
mRemote.transact(Stub.TRANSACTION_clearFirewallChain, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_setFirewallUidChainRule = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_clearFirewallChain = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
public void setFirewallUidChainRule(int uid, int networkType, boolean allow) throws android.os.RemoteException;
//zrx add

public void clearFirewallChain(java.lang.String chain) throws android.os.RemoteException;
}
