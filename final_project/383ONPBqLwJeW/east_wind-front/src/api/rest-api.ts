import axiosReq from '@/utils/axios-req'

import { EnumRsrc, enumRsrcTypeMap } from './data/index';

async function request(config) {
    const result = await axiosReq(config)
    return result.data;
}

export async function getAll<enumRsrc extends EnumRsrc>(resource: enumRsrc) {
    return await request({
        method: 'get',
        url: `/rest/${resource}`
    })
}

export async function getById<enumRsrc extends EnumRsrc>(resource: enumRsrc, id: number) {
    return await request({
        method: 'get',
        url: `/rest/${resource}/${id}`
    })
}

export async function add<enumRsrc extends EnumRsrc>(resource: enumRsrc, data: enumRsrcTypeMap[EnumRsrc]) {
    return await request({
        method: 'post',
        url: `/rest/${resource}`,
        data: data
    })
}

export async function update<enumRsrc extends EnumRsrc>(resource: enumRsrc, id: number, data: enumRsrcTypeMap[EnumRsrc]) {
    return await request({
        method: 'put',
        url: `/rest/${resource}/${id}`,
        data: data
    })
}

export async function deleteById<enumRsrc extends EnumRsrc>(resource: enumRsrc, id: number) {
    return await request({
        method: 'delete',
        url: `/rest/${resource}/${id}`
    })
}

export async function query<enumRsrc extends EnumRsrc>(resource: enumRsrc, data: enumRsrcTypeMap[EnumRsrc]) {
    return await request({
        method: 'post',
        url: `/rest/${resource}`,
        data: data
    })
}
