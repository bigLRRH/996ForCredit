import { Role } from '../enums/Role';
export interface User {
    id?: number;
    username?: string;
    password?: string;
    role?: Role;
}