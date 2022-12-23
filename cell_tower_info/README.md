# Cell tower info

To get the cell tower information in an Android app, you can use the `TelephonyManager` class which is part of the Android telephony API. Here's an example of how you can use the `TelephonyManager` to get the cell tower information in the `onCreate` method of the `MainActivity`

**Note** that the `TelephonyManager` only provides access to the cell tower information if the app has the `READ_PHONE_STATE` permission, which must be requested at runtime on devices running Android 6.0 (API level 23) or higher.



This code will loop through the list of cell info records and check the type of each record. If the record is a GSM cell info record, it will extract the cell identity (CID), mobile country code (MCC), mobile network code (MNC), location area code (LAC), and signal strength (RSSI). If the record is a CDMA cell info record, it will extract the base station ID (BSID), network ID (NID), system ID (SID), and signal strength (RSSI). If the record is a LTE cell info record, it will extract the cell identity (CI), mobile country code (MCC), mobile network code (MNC), tracking area code (TAC), and signal strength (RSRP). If the record is a WCDMA cell info record, it will extract the cell identity (CID), mobile country code (MCC), mobile network code (MNC), location area code (LAC), and signal strength (RSCP).

