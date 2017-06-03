var world = [{x: 4.0, y: 0.0, width: 4.0, height: 4.0},{x: 7.0, y: 4.0, width: 1.0, height: 4.0},{x: 0.0, y: 4.0, width: 7.0, height: 4.0},{x: 0.0, y: 0.0, width: 4.0, height: 4.0},];
var steps = [
[25.0, 35.0, 5.0, 40.0, ],
[25.0, 34.9, 5.1, 39.7, ],
[25.0, 34.7, 5.3, 39.5, ],
[25.0, 34.6, 5.4, 39.2, ],
[25.0, 34.5, 5.5, 39.0, ],
[25.0, 34.4, 5.6, 38.7, ],
[25.0, 34.2, 5.8, 38.5, ],
[25.0, 34.1, 5.9, 38.2, ],
[25.0, 34.0, 6.0, 38.0, ],
[25.0, 33.9, 6.1, 37.7, ],
[25.0, 33.8, 6.3, 37.5, ],
[25.0, 33.7, 6.4, 37.2, ],
[25.0, 33.6, 6.5, 37.0, ],
[25.0, 33.5, 6.6, 36.7, ],
[25.0, 33.4, 6.7, 36.5, ],
[25.0, 33.3, 6.8, 36.3, ],
[25.0, 33.2, 7.0, 36.0, ],
[25.0, 33.2, 7.1, 35.8, ],
[25.0, 33.1, 7.2, 35.6, ],
[25.0, 33.0, 7.3, 35.3, ],
[25.0, 32.9, 7.4, 35.1, ],
[25.0, 32.8, 7.5, 34.9, ],
[25.0, 32.8, 7.6, 34.6, ],
[25.0, 32.7, 7.7, 34.4, ],
[25.0, 32.6, 7.8, 34.2, ],
[25.0, 32.6, 7.9, 34.0, ],
[25.0, 32.5, 8.0, 33.8, ],
[25.0, 32.4, 8.1, 33.5, ],
[25.0, 32.4, 8.2, 33.3, ],
[25.0, 32.3, 8.3, 33.1, ],
[25.0, 32.2, 8.4, 32.9, ],
[25.0, 32.2, 8.5, 32.7, ],
[25.0, 32.1, 8.6, 32.5, ],
[25.0, 32.1, 8.7, 32.3, ],
[25.0, 32.0, 8.8, 32.1, ],
[24.9, 32.0, 8.9, 31.8, ],
[24.9, 31.9, 9.0, 31.6, ],
[24.9, 31.9, 9.1, 31.4, ],
[24.9, 31.9, 9.2, 31.2, ],
[24.9, 31.8, 9.3, 31.0, ],
[24.9, 31.8, 9.4, 30.8, ],
[24.9, 31.7, 9.5, 30.6, ],
[24.9, 31.7, 9.6, 30.4, ],
[24.9, 31.7, 9.7, 30.2, ],
[24.8, 31.6, 9.8, 30.1, ],
[24.8, 31.6, 9.8, 29.9, ],
[24.8, 31.6, 9.9, 29.7, ],
[24.8, 31.6, 10.0, 29.5, ],
[24.8, 31.5, 10.1, 29.3, ],
[24.8, 31.5, 10.2, 29.1, ],
[24.8, 31.5, 10.3, 28.9, ],
[24.7, 31.4, 10.4, 28.7, ],
[24.7, 31.4, 10.4, 28.6, ],
[24.7, 31.4, 10.5, 28.4, ],
[24.7, 31.4, 10.6, 28.2, ],
[24.7, 31.4, 10.7, 28.0, ],
[24.7, 31.3, 10.8, 27.8, ],
[24.7, 31.3, 10.8, 27.7, ],
[24.6, 31.3, 10.9, 27.5, ],
[24.6, 31.3, 11.0, 27.3, ],
[24.6, 31.3, 11.1, 27.1, ],
[24.6, 31.3, 11.1, 27.0, ],
[24.6, 31.3, 11.2, 26.8, ],
[24.6, 31.3, 11.3, 26.6, ],
[24.5, 31.2, 11.4, 26.4, ],
[24.5, 31.2, 11.4, 26.3, ],
[24.5, 31.2, 11.5, 26.1, ],
[24.5, 31.2, 11.6, 25.9, ],
[24.5, 31.2, 11.7, 25.8, ],
[24.4, 31.2, 11.7, 25.6, ],
[24.4, 31.2, 11.8, 25.5, ],
[24.4, 31.2, 11.9, 25.3, ],
[24.4, 31.2, 11.9, 25.1, ],
[24.4, 31.2, 12.0, 25.0, ],
[24.3, 31.2, 12.1, 24.8, ],
[24.3, 31.2, 12.1, 24.7, ],
[24.3, 31.2, 12.2, 24.5, ],
[24.3, 31.2, 12.3, 24.3, ],
[24.3, 31.2, 12.3, 24.2, ],
[24.2, 31.2, 12.4, 24.0, ],
[24.2, 31.2, 12.5, 23.9, ],
[24.2, 31.2, 12.5, 23.7, ],
[24.2, 31.2, 12.6, 23.6, ],
[24.2, 31.2, 12.7, 23.4, ],
[24.1, 31.2, 12.7, 23.3, ],
[24.1, 31.2, 12.8, 23.1, ],
[24.1, 31.2, 12.8, 23.0, ],
[24.1, 31.3, 12.9, 22.9, ],
[24.0, 31.3, 13.0, 22.7, ],
[24.0, 31.3, 13.0, 22.6, ],
[24.0, 31.3, 13.1, 22.4, ],
[24.0, 31.3, 13.1, 22.3, ],
[24.0, 31.3, 13.2, 22.1, ],
[23.9, 31.3, 13.3, 22.0, ],
[23.9, 31.3, 13.3, 21.9, ],
[23.9, 31.3, 13.4, 21.7, ],
[23.9, 31.3, 13.4, 21.6, ],
[23.8, 31.4, 13.5, 21.5, ],
[23.8, 31.4, 13.5, 21.3, ],
[23.8, 31.4, 13.6, 21.2, ],
[23.8, 31.4, 13.6, 21.0, ],
[23.7, 31.4, 13.7, 20.9, ],
[23.7, 31.4, 13.7, 20.8, ],
[23.7, 31.4, 13.8, 20.7, ],
[23.7, 31.4, 13.9, 20.5, ],
[23.6, 31.5, 13.9, 20.4, ],
[23.6, 31.5, 14.0, 20.3, ],
[23.6, 31.5, 14.0, 20.1, ],
[23.6, 31.5, 14.1, 20.0, ],
[23.5, 31.5, 14.1, 19.9, ],
[23.5, 31.5, 14.2, 19.8, ],
[23.5, 31.6, 14.2, 19.6, ],
[23.5, 31.6, 14.3, 19.5, ],
[23.4, 31.6, 14.3, 19.4, ],
[23.4, 31.6, 14.4, 19.3, ],
[23.4, 31.6, 14.4, 19.1, ],
[23.4, 31.6, 14.4, 19.0, ],
[23.3, 31.7, 14.5, 18.9, ],
[23.3, 31.7, 14.5, 18.8, ],
[23.3, 31.7, 14.6, 18.7, ],
[23.3, 31.7, 14.6, 18.5, ],
[23.2, 31.7, 14.7, 18.4, ],
[23.2, 31.8, 14.7, 18.3, ],
[23.2, 31.8, 14.8, 18.2, ],
[23.2, 31.8, 14.8, 18.1, ],
[23.1, 31.8, 14.8, 18.0, ],
[23.1, 31.8, 14.9, 17.9, ],
[23.1, 31.8, 14.9, 17.7, ],
[23.1, 31.9, 15.0, 17.6, ],
[23.0, 31.9, 15.0, 17.5, ],
[23.0, 31.9, 15.1, 17.4, ],
[23.0, 31.9, 15.1, 17.3, ],
[23.0, 32.0, 15.1, 17.2, ],
[22.9, 32.0, 15.2, 17.1, ],
[22.9, 32.0, 15.2, 17.0, ],
[22.9, 32.0, 15.3, 16.9, ],
[22.8, 32.0, 15.3, 16.8, ],
[22.8, 32.1, 15.3, 16.7, ],
[22.8, 32.1, 15.4, 16.5, ],
[22.8, 32.1, 15.4, 16.4, ],
[22.7, 32.1, 15.5, 16.3, ],
[22.7, 32.1, 15.5, 16.2, ],
[22.7, 32.2, 15.5, 16.1, ],
[22.7, 32.2, 15.6, 16.0, ],
[22.6, 32.2, 15.6, 15.9, ],
[22.6, 32.2, 15.6, 15.8, ],
[22.6, 32.2, 15.7, 15.7, ],
[22.5, 32.3, 15.7, 15.6, ],
[22.5, 32.3, 15.7, 15.5, ],
[22.5, 32.3, 15.8, 15.4, ],
[22.5, 32.3, 15.8, 15.3, ],
];