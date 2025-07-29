use aes::Aes256;
use ctr::Ctr128BE;
use ctr::cipher::{KeyIvInit, StreamCipher};
use sha2::{Sha256, Digest};
use base64::engine::general_purpose::STANDARD as base64_engine;
use base64::Engine;

pub fn encrypt(input: &str, key: &str) -> String {
    let mut hasher = Sha256::new();
    hasher.update(key.as_bytes());
    let hash = hasher.finalize();

    let iv = [0u8; 16];
    let mut buffer = input.as_bytes().to_vec();

    let mut cipher = Ctr128BE::<Aes256>::new_from_slices(&hash[..32], &iv).unwrap();
    cipher.apply_keystream(&mut buffer);

    base64_engine.encode(buffer)
}

pub fn decrypt(encoded_input: &str, key: &str) -> String {
    let mut hasher = Sha256::new();
    hasher.update(key.as_bytes());
    let hash = hasher.finalize();

    let iv = [0u8; 16];

    let mut buffer = base64_engine.decode(encoded_input).expect("Invalid base64");

    let mut cipher = Ctr128BE::<Aes256>::new_from_slices(&hash[..32], &iv).unwrap();
    cipher.apply_keystream(&mut buffer);

    String::from_utf8(buffer).expect("Invalid UTF-8")
}