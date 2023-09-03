import { Component } from '@angular/core';
import {w3cwebsocket as WebSocket} from "websocket";
@Component({
  selector: 'app-connection',
  templateUrl: './connection.component.html',
  styleUrls: ['./connection.component.css']
})
export class ConnectionComponent {


  connectSocket() {
    const ws = new WebSocket('ws://localhost:8080/web-socket'); // Replace with your WebSocket server URL

    ws.onopen = () => {
      console.log('WebSocket connection established.');
    };

  }
}
