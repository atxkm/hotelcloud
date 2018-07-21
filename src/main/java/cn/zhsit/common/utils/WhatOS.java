package cn.zhsit.common.utils;

class WhatOS
{
    public static void main8( String args[] )
    {
        System.out.println( System.getProperty("os.name") );
        System.out.println( System.getProperty("os.version") );
        System.out.println( System.getProperty("os.arch") );
    }
}