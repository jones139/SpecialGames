#!/bin/sh
adb uninstall com.example.android.snake &
ant debug
adb install bin/Snake-debug.apk

