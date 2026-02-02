🚀 Thread-Safe In-Memory Cache (Using ConcurrentHashMap)

📌 Overview

This project demonstrates a simple thread-safe in-memory cache implementation using ConcurrentHashMap in Java.

The cache improves application performance by reducing repeated database calls.
It is safe to use in multi-threaded environments, making it suitable for real-world backend applications.

🎯 Why ConcurrentHashMap?

In multi-threaded applications, multiple requests may try to access or modify the cache simultaneously.

ConcurrentHashMap:

✅ Provides thread-safe operations

✅ Allows concurrent read and write access

✅ Performs better than Collections.synchronizedMap()

✅ Reduces locking overhead using internal segmentation

Unlike HashMap, it prevents:

Race conditions

Data inconsistency

ConcurrentModificationException

⚙️ How It Works

1.When data is requested:

If present in cache → return (Cache Hit)

If not present → fetch from database and store in cache (Cache Miss)

2.Multiple threads can safely access the cache at the same time.
