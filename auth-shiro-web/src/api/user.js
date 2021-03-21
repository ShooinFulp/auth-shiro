import request from '@/utils/request'
import requestMock from  '@/utils/request_mock'

export function login(data) {
  return request({
    url: '/login/doLogin',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return requestMock({
    url: '/vue-admin-template/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/vue-admin-template/user/logout',
    method: 'post'
  })
}


