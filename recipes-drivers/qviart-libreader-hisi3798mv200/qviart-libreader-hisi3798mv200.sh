#!/bin/sh

echo extend rootfs to max size
resize2fs /dev/mmcblk0p13

echo "libreader start!!!"
mount /dev/mmcblk0p3 /boot/
/usr/bin/app_init
sleep 2
