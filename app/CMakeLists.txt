cmake_minimum_required(VERSION 3.18.1)

project("biometric_auth")

add_library(rustvault SHARED IMPORTED)
set_target_properties(rustvault PROPERTIES
        IMPORTED_LOCATION
        "${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/librustvault.so"
)
