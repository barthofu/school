#!/bin/bash

# init environment
mkdir -p environment
cd environment
mkdir bin lib lib64 tmp proc media usr usr/lib lib/x86_64-linux-gnu usr/lib/x86_64-linux-gnu/

#copy commands
cp -rfL /bin/bash ./bin
cp -rfL /bin/ps   ./bin
cp -rfL /bin/kill ./bin
cp -rfL /bin/ls   ./bin

#copy libs

    #Bash deps
    cp -rfL /lib/x86_64-linux-gnu/libtinfo.so.6   ./lib/x86_64-linux-gnu/
    cp -rfL /lib/x86_64-linux-gnu/libdl.so.2      ./lib/x86_64-linux-gnu/
    cp -rfL /lib/x86_64-linux-gnu/libc.so.6       ./lib/x86_64-linux-gnu/
    cp -rfL /lib/x86_64-linux-gnu/libc.so.6       ./lib/x86_64-linux-gnu/

    cp -rfL /lib64/ld-linux-x86-64.so.2           ./lib64/

    #ps deps
    cp -rfL /lib/x86_64-linux-gnu/libprocps.so.8      ./lib/x86_64-linux-gnu/
    cp -rfL /lib/x86_64-linux-gnu/libdl.so.2          ./lib/x86_64-linux-gnu/
    cp -rfL /lib/x86_64-linux-gnu/libc.so.6           ./lib/x86_64-linux-gnu/
    cp -rfL /lib/x86_64-linux-gnu/librt.so.1          ./lib/x86_64-linux-gnu/
    cp -rfL /lib/x86_64-linux-gnu/liblzma.so.5        ./lib/x86_64-linux-gnu/
    cp -rfL /lib/x86_64-linux-gnu/libpthread.so.0     ./lib/x86_64-linux-gnu/
    cp -rfL /lib/x86_64-linux-gnu/libgpg-error.so.0   ./lib/x86_64-linux-gnu/

    cp -rfL /usr/lib/x86_64-linux-gnu/libsystemd.so.0 ./usr/lib/
    cp -rfL /usr/lib/x86_64-linux-gnu/libzstd.so.1    ./usr/lib/
    cp -rfL /usr/lib/x86_64-linux-gnu/liblz4.so.1     ./usr/lib/
    cp -rfL /usr/lib/x86_64-linux-gnu/libgcrypt.so.20 ./usr/lib/

    cp -rfL /lib64/ld-linux-x86-64.so.2 ./lib64/

    #kill deps
    cp -rfL /lib/x86_64-linux-gnu/libprocps.so.8 ./lib/x86_64-linux-gnu/
    cp -rfL /lib/x86_64-linux-gnu/libc.so.6 ./lib/x86_64-linux-gnu/
    cp -rfL /lib/x86_64-linux-gnu/libdl.so.2 ./lib/x86_64-linux-gnu/
    cp -rfL /lib/x86_64-linux-gnu/librt.so.1 ./lib/x86_64-linux-gnu/
    cp -rfL /lib/x86_64-linux-gnu/liblzma.so.5 ./lib/x86_64-linux-gnu/
    cp -rfL /lib/x86_64-linux-gnu/libpthread.so.0 ./lib/x86_64-linux-gnu/
    cp -rfL /lib/x86_64-linux-gnu/libgpg-error.so.0 ./lib/x86_64-linux-gnu/

    cp -rfL /lib64/ld-linux-x86-64.so.2 ./lib64/

    cp -rfL /usr/lib/x86_64-linux-gnu/libsystemd.so.0 ./usr/lib/x86_64-linux-gnu/
    cp -rfL /usr/lib/x86_64-linux-gnu/libzstd.so.1 ./usr/lib/x86_64-linux-gnu/
    cp -rfL /usr/lib/x86_64-linux-gnu/liblz4.so.1 ./usr/lib/x86_64-linux-gnu/
    cp -rfL /usr/lib/x86_64-linux-gnu/libgcrypt.so.20 ./usr/lib/x86_64-linux-gnu/

    #ls deps 
    cp -rfL /lib/x86_64-linux-gnu/libselinux.so.1 ./lib/x86_64-linux-gnu/
    cp -rfL /lib/x86_64-linux-gnu/libc.so.6 ./lib/x86_64-linux-gnu/
    cp -rfL /lib/x86_64-linux-gnu/libdl.so.2 ./lib/x86_64-linux-gnu/
    cp -rfL /lib/x86_64-linux-gnu/libpthread.so.0 ./lib/x86_64-linux-gnu/
    
    cp -rfL /lib64/ld-linux-x86-64.so.2 ./lib64/

    cp -rfL /usr/lib/x86_64-linux-gnu/libpcre2-8.so.0 ./usr/lib/x86_64-linux-gnu/

# generate container binary
cd ..
gcc -o environment/container src/main.c

#end