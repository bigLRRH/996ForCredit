export default interface ModelService {
    getAll(): Promise<any[]>;
    add(model: any): Promise<number>;
    update(model: any): Promise<number>;
    delete(model: any): Promise<number>;
    getCols(): string[];
}