import { EnumRsrc, add, deleteById, getAll, getById, getEnumRsrcTblCols, update } from "@/api";
import ModelService from "./ModelService";

export default class BaseModelService<T extends EnumRsrc> implements ModelService {
    private enumRsrc: T
    constructor(enumRsrc: T) {
        this.enumRsrc = enumRsrc
    }
    async getAll(): Promise<any[]> {
        return getAll(this.enumRsrc)
    }
    async getById(id: number): Promise<any> {
        return getById(this.enumRsrc, id)
    }
    async add(model: any): Promise<number> {
        return add(this.enumRsrc, model)
    }
    async update(model: any): Promise<number> {
        const id = model.id
        if (id === undefined) {
            throw new Error('model id is undefined')
        }
        return update(this.enumRsrc, id, model)
    }
    async delete(model: any): Promise<number> {
        const id = model.id
        if (id === undefined) {
            throw new Error('model id is undefined')
        }
        return deleteById(this.enumRsrc, id)
    }
    getCols(): string[] {
        return getEnumRsrcTblCols(this.enumRsrc)
    }
}