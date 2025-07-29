use jni::JNIEnv;
use jni::objects::{JClass, JString};
use jni::sys::jstring;

use crate::functions::crypto;

#[allow(unused_attributes)] // Add this line
#[no_mangle]
pub unsafe extern "C" fn Java_com_example_biometric_1auth_RustVault_encryptText(
    mut env: JNIEnv,
    _class: JClass,
    input: JString,
    key: JString
) -> jstring {
    let input: String = env.get_string(&input).unwrap().into();
    let key: String = env.get_string(&key).unwrap().into();

    let encrypted = crypto::encrypt(&input, &key);
    env.new_string(encrypted).unwrap().into_raw()
}

#[allow(unused_attributes)] // Add this line
#[no_mangle]
pub unsafe extern "C" fn Java_com_example_biometric_1auth_RustVault_decryptText(
    mut env: JNIEnv,
    _class: JClass,
    input: JString,
    key: JString
) -> jstring {
    let input: String = env.get_string(&input).unwrap().into();
    let key: String = env.get_string(&key).unwrap().into();

    let decrypted = crypto::decrypt(&input, &key);
    env.new_string(decrypted).unwrap().into_raw()
}


//cargo clean
//cargo ndk -t arm64-v8a -t armeabi-v7a -o ../app/src/main/jniLibs build --release
