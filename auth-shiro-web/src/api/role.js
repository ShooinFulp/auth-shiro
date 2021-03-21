import request from '@/utils/request';

export function deleteRole(ids) {
  return request(
    {
      url: '/role/remove',
      method: 'post',
      data: ids
    }
  )
}

export function getList(data) {
  return request(
    {
      url: '/role/list',
      method: 'post',
      data
    }
  )
}

export function createRole(data) {
  return request(
    {
      url: '/role/add',
      method: 'post',
      data
    }
  )
}

export function removeRole(ids) {
  return request(
    {
      url: '/role/remove',
      method: 'post',
      data: ids
    }
  )
}

export function updateRole(data) {
  return request(
    {
      url: '/role/update',
      method: 'post',
      data
    }
  )
}

export function getRoleListByUserId(userId) {
  return request({
    url: '/role/getRoleListByUserId/' + userId,
    method: 'get'
  })
}

export function getAllRoleList() {
  return request({
    url: '/role/getAllRoleList',
    method: 'get'
  })
}

export function allocResource(data) {
  return request({
    url: '/role/allocResource',
    method: 'post',
    data
  })
}
