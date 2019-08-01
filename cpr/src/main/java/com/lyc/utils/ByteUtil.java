package com.lyc.utils;

import java.io.ByteArrayOutputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ByteUtil {
	  public static byte[] intToBytes(int value)
      {
          byte[] src = new byte[4];
          src[3] = (byte)((value >> 24) & 0xFF);
          src[2] = (byte)((value >> 16) & 0xFF);
          src[1] = (byte)((value >> 8) & 0xFF);
          src[0] = (byte)(value & 0xFF);
          return src;
      }
      public static int bytesToInt(byte[] src, int offset)
      {
          int value;
          value = (int)((src[offset] & 0xFF)
                  | ((src[offset + 1] & 0xFF) << 8)
                  | ((src[offset + 2] & 0xFF) << 16)
                  | ((src[offset + 3] & 0xFF) << 24));
          return value;
      }
      
      /// <summary>
      /// Convert Image to Byte[]
      /// </summary>
      /// <param name="image"></param>
      /// <returns></returns>
      public static byte[] ImageToBytes(Bitmap bitmap)
      {


    	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
    	    return baos.toByteArray();


      }

      /// <summary>
      /// Convert Byte[] to Image
      /// </summary>
      /// <param name="buffer"></param>
      /// <returns></returns>
      public static Bitmap BytesToImage(byte[] buffer)
      {
    	  return BitmapFactory.decodeByteArray(buffer, 0, buffer.length);
      }

      public static byte[] combine(byte[] a, byte[] b) {  
    	  byte[] c= new byte[a.length+b.length];  
    	   System.arraycopy(a, 0, c, 0, a.length);  
    	   System.arraycopy(b, 0, c, a.length, b.length);  
    	   return c;  
    	} 
}
