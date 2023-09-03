import { Injectable } from '@angular/core';
import { webSocket, WebSocketSubject } from 'rxjs/webSocket';

@Injectable({
    providedIn: 'root',
})
export class WebSocketService {
    private socket$: WebSocketSubject<any>;

    constructor() {
        this.socket$ = webSocket('ws://localhost:8080/web-socket'); // Replace with your server URL
    }

    sendMessage(message: string) {
        this.socket$.next({ type: 'message', content: message });
    }

    getMessages() {
        return this.socket$.asObservable();
    }
}
