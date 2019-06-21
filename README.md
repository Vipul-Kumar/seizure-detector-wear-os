# SeizureDetector - Wear OS

This seizure detector uses a smart watch working on Wear OS. The watch has an accelerometer and vibrator motor and a bluetooth radio to talk to its partner mobile app.

## Principle of Operation

It is based on an accelerometer monitoring movement. It monitors movements in a given frequency band. The idea is that it will detect the rhythmic movements associated with a seizure, but not normal day to day activities.

If the acceleration within the given frequency band is more than a threshold value, it starts a timer. If the acceleration remains above the threshold for a given period, it issues a warning beep. If it remains above the threshold for a longer specified period, the unit will send notifications about the seizure to the caregivers registered with the app.

## Task List

- [x] Read accelerometer values from the watch
- [ ] Algo to identify rhythmic movements associated with seizure
- [ ] Partner Mobile App
- [ ] Integration with some notification service

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
My code is licensed under the GNU Public Licence 