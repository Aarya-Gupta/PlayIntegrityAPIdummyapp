# Dummy Android App for Play Integrity API Testing

## 📱 Overview
This dummy Android app is designed to interact with the **Play Integrity API** to analyze its behavior under various conditions. The app performs a simple integrity check upon launch, serving as a controlled environment for testing and research purposes.

## 🎯 Objectives
1. **Trigger Play Integrity API Checks:**
   - Validate how the API responds in different device states (rooted, non-rooted, custom ROMs, etc.).

2. **Analyze Integrity Failures:**
   - Identify specific triggers that cause the API to flag a device as compromised.

3. **Evaluate Root Detection Mechanisms:**
   - Test the effectiveness of tools like **KernelSU**, **Magisk** and other related alternatives in evading Play Integrity API detections.

## 🚀 Features
- Simple UI with minimal functionality.
- Automatically initiates an integrity check on startup.
- Displays the integrity verdict (Pass/Fail) with details.

## 🔍 Research Goals
This app plays a critical role in achieving a broader research objective:

- **Understanding Security Mechanisms:**
  - Examine how Play Integrity API validates device security.
  - Detect at which stage the API identifies potential risks.

- **Root Detection Bypass Testing:**
  - Utilize KernelSU and Magisk to modify kernel and user-space behaviors.
  - Monitor API responses pre- and post-rooting.

- **Security Workflow Analysis:**
  - Map the flow of Play Integrity API calls within the Android boot and runtime environment.

## 🛠️ Tools & Technologies
- **Android Studio:** For app development.
- **Play Integrity API:** For device security verification.
- **KernelSU & Magisk:** For root management and API behavior analysis.

## ⚠️ Disclaimer
This app is intended solely for research and educational purposes. It should not be used for any malicious activity or to compromise security systems in unauthorized environments.
